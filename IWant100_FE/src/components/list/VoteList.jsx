import React from "react";
import { useNavigate } from "react-router-dom";

function getRandomColor() {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function VoteList() {
  const navigate = useNavigate();

  const handleBoxClick = () => {
    navigate(`/vote/1`);
  };

  return (
    <div className="p-6 text-left" style={{ height: '65vh', overflow: 'hidden' }}>
      <div className="overflow-y-auto" style={{ height: '100%' }}>
        {[...Array(10)].map((_) => (
          <div 
            className="bg-white p-4 rounded-lg shadow-md mb-8 cursor-pointer" 
            onClick={handleBoxClick}
          >
            <div className="flex justify-between items-center mb-2">
              <p className="font-bold ml-1 mb-4 font-esamanru">고양이보다 강아지가 귀엽다.</p>
              <p className="text-red-500 font-bold text-xs mr-1 mb-4">D-1</p>
            </div>
            <div className="flex justify-between items-center mb-2">
              <p className="text-xs ml-1 font-semibold">700명 참여</p>
              <p className="text-xs mr-1 font-semibold">투표 선택지 이름</p>
            </div>
            <div className="flex items-center justify-between">
              <div className="w-full bg-gray-200 rounded h-2.5">
                <div className="h-2.5 rounded" style={{ width: '86%', backgroundColor: getRandomColor() }}></div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default VoteList;
