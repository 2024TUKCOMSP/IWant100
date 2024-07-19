import React from "react";
import Header from "./UserHeader.jsx";
import UserProfile from "./UserProfile.jsx";
import MyList from "./MyList.jsx";

function UserPage() {
  return (
    <div>
      <div className="flex flex-col w-full min-h-screen h-full bg-primary-900">
        <div className="h-[285px] p-5">
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