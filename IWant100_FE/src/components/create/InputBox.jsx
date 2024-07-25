import React from "react";
import { Datepicker } from "flowbite-react";

function InputBox() {
  return (
    <div>
      <div className="w-full h-[180px] bg-white rounded-xl mt-[70px] shadow-default p-6 flex flex-col justify-between" >
        <input placeholder="생성할 투표 제목을 입력하세요" className="font-esamanru text-xl p-2 w-full" />
        <div className="relative max-w-sm">
          <div className="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
            <svg className="w-4 h-4 text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
              <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
            </svg>
          </div>
          <input datepicker id="default-datepicker" type="text" className="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5" placeholder="Select date" />
        </div>
      </div>
    </div>
  )
}

export default InputBox;