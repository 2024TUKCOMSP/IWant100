import React from "react";
import { useNavigate } from 'react-router-dom';
import backIcon from '../../assets/blue_back.svg';

function UserHeader(props) {
  const navigate = useNavigate();

  const handleBack = () => {
    navigate('/');
  };

  return (
    <div className="flex flex-row justify-between items-center">
      <div className="w-6 h-6 cursor-pointer">
        <img src={backIcon} alt="Back Icon" onClick={handleBack} />
      </div>
      <div className="flex-grow text-center">
        <div className="font-esamanru text-blue-500 text-2xl">{props.title}</div>
      </div>
      <div className="w-6 h-6"></div>
    </div>
  );
}

export default UserHeader;
