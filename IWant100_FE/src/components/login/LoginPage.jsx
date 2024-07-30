import React from "react";
import { useNavigate } from "react-router";

function LoginPage() {
  const navigate = useNavigate();
  const handleLogin = () => {
    const host = import.meta.env.VITE_TEST_GOOGLE_CLIENT_ID;
    const url = import.meta.env.VITE_TEST_REDIRECT_URI;
    const googleAuthUrl = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${host}&redirect_uri=${url}&access_type=offline&scope=openid%20email%20profile&response_type=code`;
    window.location.href = googleAuthUrl;
    navigate('/')
  };

  return (
    <div>
      <div className="w-full min-h-[280px] w-[698px] flex items-center border-radius-custom bg-blue-500 bg-no-repeat p-5"></div>
      <div className="w-full min-h-full relative">
        <div className="relative px-8 flex flex-col justify-center items-center">
          <div className="w-full">
            <div className="flex items-center justify-start">
              <div className="text-[38px] font-bold pr-3">Sign in</div>
              <div className="bg-login-lock-icon w-[28px] h-[33px]"></div>
            </div>
            <div className="text-2xl font-bold text-primary-700">IWANT100</div>
          </div>
        </div>
      </div>
      <div className="flex justify-center">
        <div
          className="absolute bottom-[150px] flex justify-center items-center w-[350px] h-[55px] bg-white shadow-login-button rounded-full border"
          onClick={handleLogin}
        >
          <div className="w-[79px] h-[79px] bg-google-icon"></div>
          <div className="px-2 font-semibold text-base cursor-pointer">Login with Gmail</div>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;