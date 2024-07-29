import React, { useEffect, useState } from "react";
import axios from "axios";

function VoteTitle() {
  const [voteId, setVoteId] = useState('d364bc91-49b9-4ada-b6c0-5a1632f58bae');
  const [voteInfo, setVoteInfo] = useState({ voteIntro: "", endAt: "" });
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchVoteData = async () => {
      try {
        const response = await axios.get(`http://43.201.24.231:8091/vote-content/vote/${voteId}`);
        if (response.data.success) {
          const voteInfo = response.data.voteInfo;
          const endAt = new Date(voteInfo.endAt);
          const formattedEndAt = endAt.toLocaleDateString('ko-KR');
          setVoteInfo({
            voteIntro: voteInfo.voteIntro,
            endAt: formattedEndAt,
          });
          setError("");
        } else {
          setError(response.data.message);
          console.error(response.data.message);
        }
      } catch (error) {
        setError("Error fetching vote data");
        console.error("Error fetching vote data:", error);
      }
    };

    fetchVoteData();
  }, [voteId]);

  return (
    <div>
      <div className="w-full h-[130px] bg-white rounded-xl mt-[70px] shadow-default p-[12px_24px_24px_24px] flex flex-col justify-between">
        {error ? (
          <div className="text-red-500 text-xl p-2 w-full">{error}</div>
        ) : (
          <>
            <div className="font-esamanru text-xl p-2 w-full">{voteInfo.voteIntro}</div>
            <div className="relative max-w-sm">
              <div className="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none"></div>
            </div>
            <span className="self-end break-words font-['Poppins'] font-bold text-[18px] underline tracking-[0px] leading-[1.111] text-[#414D55]">
              투표 마감 기한 : {voteInfo.endAt}
            </span>
          </>
        )}
      </div>
    </div>
  );
}

export default VoteTitle;
