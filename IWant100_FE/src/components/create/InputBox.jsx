import React, { useState } from "react";
import CustomCalendar from "./CustomCalendar";

function InputBox() {
  const [selectedDate, setSelectedDate] = useState(new Date());
  const [voteTitle, setVoteTitle] = useState('');

  const handleDateChange = (date) => {
    setSelectedDate(date);
  }

  const saveTitle = (e) => {
    setVoteTitle(e.target.value);
  }

  return (
    <div>
      <div className="w-full h-[180px] bg-white rounded-xl mt-[70px] shadow-default p-6 flex flex-col justify-between">
        <input 
          placeholder="생성할 투표 제목을 입력하세요"
          className="font-esamanru text-xl p-2 w-full"
          value={voteTitle}
          onChange={saveTitle}
        />
        <CustomCalendar onChange={handleDateChange} value={selectedDate} />
      </div>
    </div>
  )
}

export default InputBox;