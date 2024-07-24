import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './components/login/LoginPage';
import MainPage from './components/main/MainPage';
import CreateVotePage from './components/create/CreateVotePage';
import VoteListPage from './components/list/VoteListPage';
import UserPage from './components/user/UserPage';
import ResultPage from './components/result/ResultPage';
import VotePage from './components/vote/VotePage';

function App() {
  return (
    <Router>
      <div className="w-full min-h-screen flex justify-center">
        <div className="grid grid-cols-1 sm:grid-cols-[1fr_430px_1fr] lg:grid-cols-[1fr_600px_1fr] w-full max-w-full">
          <div className="hidden lg:block"></div>
          <div className="shadow-xl min-h-screen h-full">
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
          <div className="hidden lg:block"></div>
        </div>
      </div>
    </Router>
  );
}

export default App;