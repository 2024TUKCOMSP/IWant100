import React from "react";

function LoginPage() {
  return (
    <div>
      <div className="relative">
        <div className="h-[260px] bg-login-header p-5"></div>
        <div className="px-8">
          <div className="flex items-center">
            <div className="text-[38px] font-bold pr-3">Sign in</div>
            <div className="bg-login-lock-icon w-[28px] h-[33px]"></div>
          </div>
          <div className="text-2xl font-bold text-primary-700">IWANT100</div>
        </div>
      </div>
      <div>
        <div className="absolute bottom-[199px] flex justify-center items-center w-[358px] mx-8 h-[55px] bg-white shadow-login-button rounded-full border">
          <div className="w-[79px] h-[79px] bg-google-icon"></div>
          <div className="px-2 font-semibold text-base">Login with Gmail</div>
        </div>
      </div>
    </div>
  )
}

export default LoginPage;