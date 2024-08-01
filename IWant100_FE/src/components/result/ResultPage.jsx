import React from "react";
import Header from "./ResultHeader.jsx";
import Title from "./VoteTitle.jsx";
import Item from "./ResultItem.jsx";
import { useParams } from "react-router";

function ResultPage() {
  const { userId } = useParams();
  
  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] py-5 px-8">
          <div>
            <Header title="투표 결과" />
          </div>
          <Title />
        </div>
        <div className="px-5">
          <Item />
        </div>
      </div>
    </div>
  );
}

export default ResultPage;
