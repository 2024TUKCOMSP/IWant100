import React, { useState } from "react";
import Header from "../Header.jsx";
import InputBox from "./InputBox.jsx";
import VoteItem from "./CreateVoteItem.jsx";
import axios from "axios";
import { useNavigate, useParams } from "react-router";

function CreateVotePage() {
  const HOST = import.meta.env.VITE_TEST_HOST;
  const { userId } = useParams();
  const [voteTitle, setVoteTitle] = useState('');
  const [selectedDate, setSelectedDate] = useState(); 
  const [isDuplication, setIsDuplication] = useState(false);
  const [voteItems, setVoteItems] = useState([{ id: 1, value: "" }]);

  const navigate = useNavigate();

  const handleDuplication = () => {
    setIsDuplication(!isDuplication);
  };

  const addVoteItem = () => {
    if (voteItems.length < 6) {
      setVoteItems([...voteItems, { id: voteItems.length + 1, value: "" }]);
    }
  };

  const updateVoteItem = (id, value) => {
    setVoteItems(
      voteItems.map(item => (item.id === id ? { ...item, value } : item))
    );
  };

  const removeVoteItem = id => {
    setVoteItems(voteItems.filter(item => item.id !== id));
  };

  const handleSubmit = async () => {
    const filteredVoteItems = voteItems
      .filter(item => item.value.trim() !== "")
      .map(item => item.value);

    if (voteTitle.trim() === '') {
      alert('투표 제목을 입력하세요.');
      return;
    }
    
    if (filteredVoteItems.length < 2) {
      alert('투표 항목을 최소 2개 이상 입력하세요.');
      return;
    }
    
    if (!selectedDate) {
      alert('마감 날짜를 설정하세요.');
      return;
    }
  
    // 선택된 날짜를 로컬 시간대 기준으로 설정
    const localDate = new Date(selectedDate);
    localDate.setHours(0, 0, 0, 0); // 시간을 00:00:00으로 설정하여 날짜의 시작을 보장
    
    // 서버에 전송하기 위해 UTC로 변환
    const utcDate = new Date(Date.UTC(
      localDate.getFullYear(),
      localDate.getMonth(),
      localDate.getDate()
    ));
  
    const res = await axios.post(`${HOST}/vote`, {
      "userId": userId,
      "voteIntro": voteTitle,
      "isDuplication": isDuplication,
      "endAt": utcDate.toISOString(), // ISO 문자열로 변환하여 서버에 전송
      "voteItemList": filteredVoteItems
    });
  
    if (res.data.success) {
      navigate(`/result/${voteId}/${userId}`);
    } else {
      alert('투표 생성을 하지 못했어요.');
    }
  }; 

  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="bg-blue-500 h-[285px] shadow-default rounded-b-[50%_20%] py-5 px-8">
          <div>
            <Header title="투표 생성" handleSubmit={handleSubmit} />
            <InputBox voteTitle={voteTitle} setVoteTitle={setVoteTitle} selectedDate={selectedDate} setSelectedDate={setSelectedDate} />
          </div>
          <div className="px-16 w-full h-[60px] rounded-xl bg-white my-4 shadow-default flex items-center justify-center">
            <div 
              className="flex items-center cursor-pointer"
              onClick={handleDuplication}
            >
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle
                  cx="12" cy="12" r="12"
                  className={`${isDuplication ? 'fill-primary-700' : 'fill-[#CCCCCC]'}`}
                />
                <path d="M7.19995 12L10.8 15.6L18 8.39999" stroke="white" strokeWidth="2" strokeLinecap="round"/>
              </svg>  
              <div className={`ml-2 font-esamanru text-lg select-none ${isDuplication ? 'text-primary-700' : 'text-secondary-900'}`}>복수 투표 사용</div>
            </div>
          </div>
          <div className="w-full h-auto bg-primary-600 rounded-xl p-5">
            {voteItems.map(item => (
              <VoteItem
                key={item.id}
                id={item.id}
                value={item.value}
                onChange={updateVoteItem}
                onRemove={removeVoteItem}
              />
            ))}
            {voteItems.length < 6 && (
              <div className="w-full h-[56px] bg-primary-700 shadow-default rounded-lg flex justify-center items-center hover:brightness-75 cursor-pointer" onClick={addVoteItem}>
                <svg width="16" height="20" viewBox="0 0 16 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M14.6151 10.152H9.50311V15.336H7.46311V10.152H2.37511V8.304H7.46311V3.096H9.50311V8.304H14.6151V10.152Z" fill="white"/>
                </svg>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default CreateVotePage;