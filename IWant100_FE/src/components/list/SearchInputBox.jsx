import React, { useState } from "react";
import searchIcon from '../../assets/search.svg';

function SearchInputBox({ onSearch }) {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearchChange = (event) => {
    const value = event.target.value;
    setSearchTerm(value);
    onSearch(value);
  };

  return (
    <div className="flex justify-center mt-0">
      <div className="relative w-full flex justify-center mt-[100px]">
        <input
          type="text"
          placeholder="투표 제목을 입력하세요."
          value={searchTerm}
          onChange={handleSearchChange}
          className="font-semibold w-full pt-5 pb-5 p-3 pl-5 pr-12 text-gray-700 bg-white rounded-xl shadow-md focus:outline-none"
        />
        <button className="absolute top-1 right-1 mt-3 mr-3">
          <img src={searchIcon} alt="Search Icon" className="w-6 h-6 text-blue-500"/>
        </button>
      </div>
    </div>
  );
}

export default SearchInputBox;
