import React from "react";
import Header from "./UserHeader.jsx";
import UserProfile from "./UserProfile.jsx";
import MyList from "./MyList.jsx";

function UserPage() {
  return (
    <div>
      <div className="px-8 py-5 flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="h-[285px]">
          <div>
            <Header title="내정보" />
          </div>
          <UserProfile />
        </div>
        <MyList />
      </div>
    </div>
  );
}

export default UserPage;
