import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";

function getRandomColor() {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function MyList() {
  const HOST = import.meta.env.VITE_TEST_HOST;

  const [voteList, setVoteList] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
  const { userId } = useParams();

  useEffect(() => {
    const fetchVotes = async () => {
      try {
        const response = await axios.get(`${HOST}/vote/all/user/${userId}`);

        if (response.data.success) {
          setVoteList(response.data.voteList);
        } else {
          setErrorMessage(response.data.message);
        }
      } catch (error) {
        console.error("There was an error!", error);
        setErrorMessage("An error occurred while fetching the data.");
      }
    };

    fetchVotes();
  }, [userId]);

  const handleDelete = async (voteId) => {
    try {
      const response = await axios.delete(`${HOST}/vote`, {
        data: {
          voteId: voteId,
          userId: userId
        }
      });
      
      if (response.data.success) {
        setVoteList(voteList.filter(vote => vote.voteId !== voteId));
      } else {
        setErrorMessage(response.data.message);
      }
    } catch (error) {
      console.error("There was an error!", error);
      setErrorMessage("An error occurred while deleting the vote.");
    }
  };

  return (
    <div className="text-left mt-[-16px]" style={{ height: '65vh', overflow: 'hidden' }}>
      <h2 className="text-2xl font-esamanru text-blue-500 mb-4">내가 만든 투표</h2>
      <div className="overflow-y-auto" style={{ height: '100%' }}>
        {errorMessage && <p className="text-red-500">{errorMessage}</p>}
        {voteList.length > 0 ? voteList.map((vote) => (
          <div key={vote.voteId} className="bg-white p-4 rounded-lg shadow-md mb-8">
            <div className="flex justify-between items-center mb-2">
              <p className="font-bold ml-1 mb-4 font-esamanru">{vote.voteIntro}</p>
              <p
                className="text-red-500 font-bold text-xs mr-1 mb-4 cursor-pointer"
                onClick={() => handleDelete(vote.voteId)}
              >
                삭제
              </p>
            </div>
            <div className="flex justify-between items-center mb-2">
              <p className="text-xs ml-1 font-semibold">{vote.voteCount}명 참여</p>
              <p className="text-xs mr-1 font-semibold">{vote.voteItemContent}</p>
            </div>
            <div className="flex items-center justify-between">
              <div className="w-full bg-gray-200 rounded h-2.5">
                <div className="h-2.5 rounded" style={{ width: `${vote.voteCount}%`, backgroundColor: getRandomColor() }}></div>
              </div>
            </div>
          </div>
        )) : <p className="text-center text-gray-500">No votes found</p>}
      </div>
    </div>
  );
}

export default MyList;
