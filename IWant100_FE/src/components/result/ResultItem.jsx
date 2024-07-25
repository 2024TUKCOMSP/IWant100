import React from "react";

function getRandomColor() {
  const letters = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function ResultItem() {
  const resultData = [
    { label: "매우 그렇다", width: "120px" },
    { label: "그렇다", width: "108.7px" },
    { label: "보통이다", width: "256.4px" },
    { label: "그렇지 않다", width: "236px" },
    { label: "매우 그렇지 않다", width: "167.8px" }
  ].map(item => ({ ...item, color: getRandomColor() }));

  return (
    <div className="rounded-[30px] bg-[#E8ECFA] flex flex-col p-4 box-sizing-border mt-6">
      <div className="shadow-sm rounded-[16px] bg-white flex flex-col items-center p-10 w-full box-sizing-border">
        {resultData.map((item, index) => (
          <div key={index} className="mb-6 flex flex-col items-center w-full box-sizing-border">
            <div className="mb-4 flex justify-between w-full box-sizing-border">
              <p className="w-24 font-bold text-[13px] text-[#414D55]"></p>
              <div className="text-[#28B5E1] text-[12px] font-medium">
                {item.label}
              </div>
            </div>
            <div className="rounded-[2.5px] bg-[#E4EAF0] w-full h-[10px] box-sizing-border">
              <div className="rounded-[2px]" style={{ backgroundColor: item.color, width: item.width, height: '10px' }}></div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ResultItem;
