import { BrowserRouter, Route, Routes } from 'react-router-dom';
import LoginPage from './components/login/LoginPage';
import MainPage from './components/main/MainPage';
import CreateVotePage from './components/create/CreateVotePage';
import VoteListPage from './components/list/VoteListPage';
import UserPage from './components/user/UserPage';
import ResultPage from './components/result/ResultPage';
import VotePage from './components/vote/VotePage';

function App() {
  return (
    <BrowserRouter>
      <div className="w-full min-h-screen grid grid-cols-1">
        <div className="bg-white"></div>
        <div className="min-h-screen h-full flex justify-center items-center">
          <div className="shadow-2xl min-h-screen h-full w-full h-full w-full min-w-[405px] max-w-[500px]">
            <Routes>
              <Route path="/login" element={<LoginPage />} />
              <Route path="/" element={<MainPage />} />
              <Route path="/create" element={<CreateVotePage />} />
              <Route path="/list" element={<VoteListPage />} />
              <Route path="/user" element={<UserPage />} />
              <Route path="/result" element={<ResultPage />} />
              <Route path="/vote/:id" element={<VotePage />} />
            </Routes>
          </div>
        </div>
        <div className="bg-white"></div>
      </div>
    </BrowserRouter>
  );
}

export default App;