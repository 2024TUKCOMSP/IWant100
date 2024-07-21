import React from "react";

function LoginPage() {
  return (
    <div className="relative">
      <div className="h-[260px] bg-login-header p-5"></div>
      <div className="px-8">
        <div className="flex items-center">
          <div className="text-[38px] font-bold pr-3">Sign in</div>
          <div className="bg-login-lock-icon w-[28px] h-[33px]"></div>
        </div>
        <div className="text-2xl font-bold text-primary-700">IWANT100</div>
      </div>
      <div className="absolute bottom-[80px] mx-8 h-[55px] bg-white shadow-login-button rounded-full"></div>
    </div>
  )
}

export default LoginPage;