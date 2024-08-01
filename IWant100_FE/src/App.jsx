import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import LoginPage from './components/login/LoginPage';
import MainPage from './components/main/MainPage';
import CreateVotePage from './components/create/CreateVotePage';
import VoteListPage from './components/list/VoteListPage';
import UserPage from './components/user/UserPage';
import ResultPage from './components/result/ResultPage';
import VotePage from './components/vote/VotePage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(true);
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    console.log('isLoggedIn:', isLoggedIn, 'userId:', userId);
  }, [isLoggedIn, userId]);

  return (
    <BrowserRouter>
      <div className="w-full min-h-screen grid grid-cols-1">
        <div className="bg-white"></div>
        <div className="min-h-screen h-full flex justify-center items-center">
          <div className="shadow-2xl min-h-screen h-full w-full min-w-[405px] max-w-[500px]">
            <Routes>
              {isLoggedIn ? (
                <>
                  <Route path="/" element={<MainPage />} />
                  <Route path="/create" element={<CreateVotePage />} />
                  <Route path="/list" element={<VoteListPage />} />
                  <Route path="/user" element={<UserPage />} />
                  <Route path="/result/:voteId" element={<ResultPage />} />
                  <Route path="/vote/:voteId" element={<VotePage />} />
                  <Route path="*" element={<Navigate to="/" replace />} /> {/* 모든 다른 경로는 /로 리디렉션 */}
                </>
              ) : (
                <>
                  <Route path="/login" element={<LoginPage />} />
                  <Route path="*" element={<Navigate to="/login" replace />} /> {/* 기본 경로를 /login으로 리디렉션 */}
                </>
              )}
            </Routes>
          </div>
        </div>
        <div className="bg-white"></div>
      </div>
    </BrowserRouter>
  );
}

export default App;