import React from "react";

function VoteItem(props) {
  return (
    <div>
      {[...Array(6)].map((_) => (
        <div className="w-full mb-5 last:mb-0 font-esamanru p-4 bg-white rounded-lg flex justify-between items-center shadow-default cursor-pointer active:bg-primary-700 active:text-white">
          <div>1. 매우 그렇다.</div>
        </div>
      ))}
    </div>
  )
}

export default VoteItem;