import React from "react";
import Header from "../Header.jsx";
import InputBox from "./InputBox.jsx";
import VoteItem from "./CreateVoteItem.jsx";

function CreateVotePage() {
  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] py-5 px-8">
          <div>
            <Header title="투표 생성" />
            <InputBox />
          </div>
          <div className="px-16 w-full h-[60px] rounded-xl bg-white my-4 shadow-default flex items-center justify-center">
            <div className="flex items-center cursor-pointer">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle cx="12" cy="12" r="12" fill="#CCCCCC"/>
                <path d="M7.19995 12L10.8 15.6L18 8.39999" stroke="white" strokeWidth="2" strokeLinecap="round"/>
              </svg>  
              <div className="ml-2 font-esamanru text-lg text-secondary-900">복수 투표 사용</div>
            </div>
          </div>
          <div className="w-full h-auto bg-primary-600 rounded-xl p-5">
            <VoteItem />
            <div className="w-full h-[56px] bg-primary-700 shadow-default rounded-lg flex justify-center items-center hover:brightness-75 cursor-pointer">
              <svg width="16" height="20" viewBox="0 0 16 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M14.6151 10.152H9.50311V15.336H7.46311V10.152H2.37511V8.304H7.46311V3.096H9.50311V8.304H14.6151V10.152Z" fill="white"/>
              </svg>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CreateVotePage;