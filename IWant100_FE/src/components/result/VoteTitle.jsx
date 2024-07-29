import React from "react";

function VoteTitle({ title, endDate }) {
  return (
    <div>
      <div className="w-full h-[130px] bg-white rounded-xl mt-[70px] shadow-default p-[12px_24px_24px_24px] flex flex-col justify-between">
        <div className="font-esamanru text-xl p-2 w-full">{title}</div>
        <div className="relative max-w-sm">
          <div className="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none"></div>
        </div>
        <span className="self-end break-words font-['Poppins'] font-bold text-[18px] underline tracking-[0px] leading-[1.111] text-[#414D55]">
          투표 마감 기한 : {endDate}
        </span>
      </div>
    </div>
  );
}

export default VoteTitle;