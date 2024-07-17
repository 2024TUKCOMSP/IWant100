import React from "react";
import profileIcon from '../../assets/profile_icon.svg';
import createIcon from '../../assets/create_icon.svg';
import voteIcon from '../../assets/vote_icon.svg';
import tinoIcon from '../../assets/tino.svg';

function MainPage() {
  return (
    <div className="text-center h-screen bg-gray-100">
      <header className="bg-blue-500 p-5 text-white relative h-1/3 flex items-start justify-between rounded-b-[50%_20%]">
        <div className="flex flex-col items-start ml-4 mt-7">
          <h1 className="text-xl font-bold">모두의 선택이 모이는 곳</h1>
          <h2 className="text-2xl mb-2 font-bold">IWANT100</h2>
        </div>
        <div className="absolute top-6 right-6">
          <img src={profileIcon} alt="Profile" className="w-6 h-6" />
        </div>
        <img src={tinoIcon} alt="Tino" className="absolute right-[5%] bottom-[10%] w-1/2 h-auto" />
      </header>
      <main className="p-6 text-left">
        <h2 className="text-red-500 text-2xl font-bold mb-4">HOT</h2>
        <div className="bg-white p-4 rounded-lg shadow-md mb-8">
          <h3 className="font-bold mt-2 ml-2 mb-10">Popular vote</h3>
          <p className="font-bold ml-4 mb-4">고양이보다 강아지가 귀엽다.</p>
          <div className="flex justify-between items-center mb-2">
            <p className="text-xs ml-1">648 of 751</p>
            <p className="text-xs mr-1">투표 선택지 이름</p>
          </div>
          <div className="flex items-center justify-between">
            <div className="w-full bg-gray-200 rounded h-2.5">
              <div className="bg-red-500 h-2.5 rounded" style={{ width: '86%' }}></div>
            </div>
          </div>
        </div>
        <section className="flex flex-col gap-8">
          <button className="bg-white text-blue-600 p-5 rounded hover:bg-blue-600 hover:text-white text-2xl font-bold flex items-center justify-between shadow-md">
            <img src={createIcon} alt="Create Icon" className="w-9 h-12 ml-3" />
            <span>투표 생성</span>
          </button>
          <button className="bg-white text-blue-600 p-5 rounded hover:bg-blue-600 hover:text-white text-2xl font-bold flex items-center justify-between shadow-md">
            <img src={voteIcon} alt="Vote Icon" className="w-9 h-12 ml-3" />
            <span>투표 목록</span>
          </button>
        </section>
      </main>
    </div>
  );
}

export default MainPage;
