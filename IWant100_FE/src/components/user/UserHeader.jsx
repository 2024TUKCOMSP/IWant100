import React from "react";
import { useNavigate, useParams } from "react-router";
import backIcon from '../../assets/blue_back.svg';

function UserHeader(props) {
  const navigate = useNavigate();
  const { userId } = useParams();

  const handleBack = () => {
    navigate(`/${userId}`);
  };

  const handleLogout = () => {
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('userId');
    navigate('/login');
    window.location.reload();
  };

  return (
    <div className="flex flex-row justify-between items-center">
      <div className="w-10 h-6 cursor-pointer">
        <img src={backIcon} alt="Back Icon" onClick={handleBack} />
      </div>
      <div className=" text-center">
        <div className="font-esamanru text-blue-500 text-2xl">{props.title}</div>
      </div>
      <div className="font-esamanru text-blue-500 text-xs underline cursor-pointer" onClick={handleLogout}>
        Logout
      </div>
    </div>
  );
}

export default UserHeader;