import React from "react";
import { useNavigate, useParams } from 'react-router-dom';
import profileIcon from '../../assets/profile_icon.svg';

function ListHeader(props) {
  const { userId } = useParams();
  const navigate = useNavigate();

  const handleUser = () => {
    navigate(`/user/${userId}`);
  };

  const handleBack = () => {
    navigate(`/${userId}`);
  };

  return (
    <div>
      <div className="flex flex-row justify-between items-center">
        <div className="w-8 h-8 cursor-pointer" onClick={handleBack}>
          <div className="bg-back-arrow-icon bg-no-repeat w-full h-full"></div>
        </div>
        <div className="font-esamanru text-white text-2xl">{props.title}</div>
        <div className="w-6 h-6 cursor-pointer">
          <img src={profileIcon} alt="Profile Icon" onClick={handleUser} />
        </div>
      </div>
    </div>
  );
}

export default ListHeader;
