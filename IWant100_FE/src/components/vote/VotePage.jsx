import React from "react";
import VoteTitle from "../result/VoteTitle";
import VoteHeader from "../vote/VoteHeader";
import VoteItem from "../vote/VoteItem";
import { useNavigate } from "react-router";

function VotePage() {
  const navigate = useNavigate();

  const handleBoxClick = () => {
    navigate(`/result`);
  };

  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] p-5">
          <VoteHeader title="투표 하기" />
          <VoteTitle />
          <div className="px-16 w-full h-[60px] rounded-xl bg-white my-4 shadow-default flex items-center justify-between">
            <div className="flex items-center">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle cx="12" cy="12" r="12" fill="#CCCCCC"/>
                <path d="M7.19995 12L10.8 15.6L18 8.39999" stroke="white" strokeWidth="2" strokeLinecap="round"/>
              </svg>  
              <div className="ml-2 font-esamanru text-lg text-secondary-900">복수 투표</div>
            </div>
            <div className="flex items-center">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle cx="12" cy="12" r="12" fill="#CCCCCC"/>
                <path d="M7.19995 12L10.8 15.6L18 8.39999" stroke="white" strokeWidth="2" strokeLinecap="round"/>
              </svg>  
              <div className="ml-2 font-esamanru text-lg text-secondary-900">익명 사용</div>
            </div>
          </div>
          <div className="w-full h-auto bg-primary-600 rounded-xl p-5 mb-5">
            <VoteItem />
          </div>
          <div 
            onClick={handleBoxClick}
            className="w-full font-esamanru text-white text-[18px] h-[56px] bg-primary-700 shadow-default rounded-lg flex justify-center items-center hover:brightness-75 cursor-pointer">
            투표 확인
          </div>
        </div>
      </div>
    </div>
  )
}

export default VotePage;