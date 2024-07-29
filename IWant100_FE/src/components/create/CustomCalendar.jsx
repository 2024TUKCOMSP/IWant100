import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import moment from "moment";

const CustomCalendar = ({onChange, value}) => {
  const [nowDate, setNowDate] = useState("날짜를 선택하세요.");
  const [isOpen, setIsOpen] = useState(false);

  const handleCalendarOpen = () => {
    setIsOpen(!isOpen);
  }

  const handleDateChange = (selectedDate) => {
    onChange(selectedDate);
    setIsOpen(false);
    setNowDate(moment(selectedDate).format("YYYY년 MM월 DD일"));
  }

  return (
    <div className='relative z-10 flex flex-col justify-end items-end'>
      <div className='w-full flex justify-end underline' onClick={handleCalendarOpen}>투표 마감일: {nowDate}</div>
      {isOpen && (
        <div className='absolute top-full'>
          <Calendar 
            onChange={handleDateChange}
            value={value}
            formatDay={(locale, date) => moment(date).format("DD")}
          ></Calendar>
        </div>
      )}
    </div>
  );
}

export default CustomCalendar;