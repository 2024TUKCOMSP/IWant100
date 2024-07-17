import React from "react";

function Header(props) {
  return (
    <div>
      <div className="flex flex-row justify-between items-center">
        <div className="w-8 h-8 bg-back-arrow-icon bg-no-repeat"></div>
        <div className="font-esamanru text-white text-2xl">{props.title}</div>
        <div className="w-6 h-6 bg-submit-icon bg-no-repeat"></div>
      </div>
    </div>
  )
}

export default Header;