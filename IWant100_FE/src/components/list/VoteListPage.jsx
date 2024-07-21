import React from "react";
import Header from "./ListHeader.jsx";
import SearchInputBox from "./SearchInputBox.jsx";
import VoteList from "./VoteList.jsx";

function VoteListPage() {
  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] p-5">
          <div>
            <Header title="투표 목록" />
          </div>
          <SearchInputBox />
        </div>
        <VoteList /> 
      </div>
    </div>
  );
}

export default VoteListPage;
