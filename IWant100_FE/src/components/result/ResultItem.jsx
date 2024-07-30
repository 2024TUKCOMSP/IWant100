import React, { useEffect, useState } from "react";
import axios from "axios";

function getRandomColor() {
  const letters = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function ResultItem() {
  const HOST = import.meta.env.VITE_TEST_HOST;

  const [resultData, setResultData] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
  const voteId = 'd364bc91-49b9-4ada-b6c0-5a1632f58bae';

  useEffect(() => {
    axios.get(`${HOST}/vote-content/vote/${voteId}`)
      .then(response => {
        if (response.data.success) {
          const voteInfo = response.data.voteInfo;
          const coloredData = voteInfo.voteItemList.map(item => ({
            voteItemId: item.voteItemId,
            voteItemCount: item.voteItemCount,
            color: getRandomColor()
          }));
          setResultData(coloredData);
        } else {
          setErrorMessage(response.data.message);
        }
      })
      .catch(error => {
        setErrorMessage("An error occurred while fetching the data.");
      });
  }, [voteId]);

  if (errorMessage) {
    return <div>{errorMessage}</div>;
  }

  const totalVotes = resultData.reduce((sum, item) => sum + item.voteItemCount, 0);

  return (
    <div className="rounded-[30px] bg-[#E8ECFA] flex flex-col p-4 box-sizing-border mt-6">
      <div className="shadow-sm rounded-[16px] bg-white flex flex-col items-center p-10 w-full box-sizing-border">
        {resultData.map((item, index) => (
          <div key={index} className="mb-6 flex flex-col items-center w-full box-sizing-border">
            <div className="mb-4 flex justify-between w-full box-sizing-border">
              <p className="w-24 font-bold text-[13px] text-[#414D55]">
                {item.voteItemContent}
              </p>
              <div className="text-[#28B5E1] text-[12px] font-medium">
                Votes: {item.voteItemCount}
              </div>
            </div>
            <div className="rounded-[2.5px] bg-[#E4EAF0] w-full h-[10px] box-sizing-border">
              <div className="rounded-[2px]" style={{ backgroundColor: item.color, width: `${(item.voteItemCount / totalVotes) * 100}%`, height: '10px' }}></div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ResultItem;
