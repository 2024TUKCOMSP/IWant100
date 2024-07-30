import React from "react";

function VoteItem({ isActive, setIsActive, voteItemList, isDuplication }) {
  const handleItemClick = (itemId) => {
    setIsActive(itemId);
  };

  return (
    <div>
      {voteItemList.map((item) => (
        <div
          key={item.voteItemId}
          className={`w-full mb-5 last:mb-0 font-esamanru p-4 rounded-lg flex justify-between items-center shadow-default cursor-pointer ${isActive.includes(item.voteItemId) ? 'bg-primary-700 text-white' : 'bg-white text-black'}`}
          onClick={() => handleItemClick(item.voteItemId)}
        >
          <div>{item.voteItemContent}</div>
        </div>
      ))}
    </div>
  );
}

export default VoteItem;
