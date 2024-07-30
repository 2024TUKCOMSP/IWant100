import React from "react";

function CreateVoteItem({ id, value, onChange, onRemove }) {
  const handleInputChange = (e) => {
    onChange(id, e.target.value);
  };

  const handleRemoveClick = () => {
    onRemove(id);
  };

  return (
    <div>
      <div className="w-full p-4 mb-5 bg-white rounded-lg flex justify-between items-center shadow-default">
        <input
          placeholder="투표 항목을 입력하세요"
          className="w-11/12 text-base font-semibold" 
          value={value} 
          onChange={handleInputChange}
        />
        <svg 
          width="13" 
          height="13" 
          viewBox="0 0 13 13" 
          fill="none" 
          xmlns="http://www.w3.org/2000/svg" 
          className="cursor-pointer"
          onClick={handleRemoveClick}
        >
          <path d="M12.8095 11.8898C12.8699 11.9502 12.9178 12.0219 12.9505 12.1008C12.9832 12.1797 13 12.2643 13 12.3497C13 12.4351 12.9832 12.5196 12.9505 12.5985C12.9178 12.6774 12.8699 12.7491 12.8095 12.8095C12.7491 12.8699 12.6774 12.9178 12.5985 12.9505C12.5196 12.9832 12.4351 13 12.3497 13C12.2643 13 12.1797 12.9832 12.1008 12.9505C12.0219 12.9178 11.9502 12.8699 11.8898 12.8095L6.5 7.41889L1.11017 12.8095C0.988215 12.9315 0.822802 13 0.650325 13C0.477848 13 0.312435 12.9315 0.190476 12.8095C0.0685162 12.6876 3.39993e-09 12.5222 0 12.3497C-3.39993e-09 12.1772 0.0685162 12.0118 0.190476 11.8898L5.58111 6.5L0.190476 1.11017C0.0685162 0.988215 -1.28505e-09 0.822802 0 0.650325C1.28505e-09 0.477848 0.0685162 0.312435 0.190476 0.190476C0.312435 0.0685162 0.477848 1.28505e-09 0.650325 0C0.822802 -1.28505e-09 0.988215 0.0685162 1.11017 0.190476L6.5 5.58111L11.8898 0.190476C12.0118 0.0685162 12.1772 -3.39993e-09 12.3497 0C12.5222 3.39993e-09 12.6876 0.0685162 12.8095 0.190476C12.9315 0.312435 13 0.477848 13 0.650325C13 0.822802 12.9315 0.988215 12.8095 1.11017L7.41889 6.5L12.8095 11.8898Z" fill="#C5BDBD"/>
        </svg>
      </div>
    </div>
  )
}

export default CreateVoteItem;