import React from "react";
import { useNavigate, useParams } from "react-router";

function Header({ title, handleSubmit }) {
  const navigate = useNavigate();
  const { userId } = useParams();

  const handleBackArrow = () => {
    navigate(`/${userId}`);
  };

  return (
    <div>
      <div className="flex flex-row justify-between items-center">
        <div
          className="w-8 h-8 bg-back-arrow-icon bg-no-repeat cursor-pointer"
          onClick={handleBackArrow}
        ></div>
        <div className="font-esamanru text-white text-2xl">{title}</div>
        <div onClick={handleSubmit} className="w-6 h-6 bg-submit-icon bg-no-repeat"></div>
      </div>
    </div>
  )
}

export default Header;