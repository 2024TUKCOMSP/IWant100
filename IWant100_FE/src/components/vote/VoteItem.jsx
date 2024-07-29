import React from "react";

function VoteItem({ voteItemList }) {
  return (
    <div>
      {voteItemList.map((item, index) => (
        <div
          key={item.voteItemId}
          className="w-full mb-5 last:mb-0 font-esamanru p-4 bg-white rounded-lg flex justify-between items-center shadow-default cursor-pointer active:bg-primary-700 active:text-white"
        >
          <div>{index + 1}. {item.voteItemContent}</div>
        </div>
      ))}
    </div>
  );
}

export default VoteItem;