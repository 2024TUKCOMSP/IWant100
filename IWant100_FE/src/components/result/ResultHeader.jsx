import React from "react";
import { useNavigate } from 'react-router-dom';
import homeIcon from '../../assets/home_icon.svg';

function ListHeader(props) {
  const navigate = useNavigate();

  const handleHome = () => {
    navigate('/');
  };

  const handleBack = () => {
    navigate('/list');
  };

  return (
    <div>
      <div className="flex flex-row justify-between items-center">
        <div className="w-8 h-8 cursor-pointer" onClick={handleBack}>
          <div className="bg-back-arrow-icon bg-no-repeat w-full h-full"></div>
        </div>
        <div className="font-esamanru text-white text-2xl">{props.title}</div>
        <div className="w-6 h-6 cursor-pointer">
          <img src={homeIcon} alt="Home Icon" onClick={handleHome} />
        </div>
      </div>
    </div>
  );
}

export default ListHeader;
