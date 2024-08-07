import React, { useEffect, useState } from "react";
import axios from "axios";
import moment from "moment";
import VoteTitle from "../result/VoteTitle";
import VoteHeader from "../vote/VoteHeader";
import VoteItem from "../vote/VoteItem";
import { useNavigate, useParams } from "react-router";

function VotePage() {
  const HOST = import.meta.env.VITE_TEST_HOST;

  const { voteId } = useParams();
  const { userId } = useParams();
  const [vote, setVote] = useState(null);
  const [isActive, setIsActive] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const getVoteData = async () => {
    try {
      const res = await axios.get(`${HOST}/vote-content/vote/${voteId}/user/${userId}`);
      setVote(res.data.voteInfo);
    } catch (e) {
      setError(e);
    }
    setLoading(false);
  };

  const navigate = useNavigate();

  useEffect(() => {
    getVoteData(); // 컴포넌트가 마운트될 때 데이터 가져오기
  }, []); // 빈 배열을 의존성으로 사용하여 한 번만 실행

  const handleSelectionChange = (itemId) => {
    if (vote.isDuplication) {
      setIsActive((prevActive) =>
        prevActive.includes(itemId)
          ? prevActive.filter((id) => id !== itemId)
          : [...prevActive, itemId]
      );
    } else {
      setIsActive([itemId]);
    }
  };

  const handleVoteSubmit = async () => {
    console.log({
      "userId" : userId,
      "voteId" : voteId,
      "voteItemList" : isActive
    })

    const res = await axios.post(`${HOST}/vote-content`, {
      "userId" : userId,
      "voteId" : voteId,
      "voteItemList" : isActive
    })

    if(res.data.success) {
      navigate(`/result/${voteId}/${userId}`);
    } else {
      alert('투표를 실패했습니다.');
    }
  }

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러 발생!!</div>;
  if (!vote) return null;

  // 날짜 포맷 적용
  const formattedEndDate = moment(vote.endAt).format("YYYY. MM. DD.");

  return (
    <div className="min-h-screen bg-primary-900">
      <div className="flex flex-col">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] px-8 py-5">
          <VoteHeader title="투표 하기" />
          <VoteTitle title={vote.voteIntro} endDate={formattedEndDate} />
        </div>
        <div className="px-8 h-full">
          <div className="w-full h-[60px] rounded-xl bg-white my-4 shadow-default flex items-center justify-center">
            <div className="flex items-center mr-5">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle
                  cx="12" cy="12" r="12"
                  className={`${vote.isDuplication ? 'fill-primary-700' : 'fill-[#CCCCCC]'}`}
                />
                <path d="M7.19995 12L10.8 15.6L18 8.39999" stroke="white" strokeWidth="2" strokeLinecap="round"/>
              </svg>  
              <div className={`ml-2 font-esamanru text-xl flex items-center ${vote.isDuplication ? 'text-primary-700' : 'text-secondary-900'}`}>
                {vote.isDuplication ? '복수 투표 가능' : '복수 투표 불가능'}
              </div>
            </div>
          </div>
          <div className="w-full h-auto bg-primary-600 rounded-xl p-5 mb-5">
            <VoteItem
              isActive={isActive}
              setIsActive={handleSelectionChange}
              voteItemList={vote.voteItemList}
              isDuplication={vote.isDuplication}
            />
          </div>
          <div
            onClick={handleVoteSubmit}
            className="w-full mb-5 font-esamanru text-white text-[18px] h-[56px] bg-primary-700 shadow-default rounded-lg flex justify-center items-center hover:brightness-75 cursor-pointer"
          >
            투표 하기
          </div>
        </div>
      </div>
    </div>
  );
}

export default VotePage;