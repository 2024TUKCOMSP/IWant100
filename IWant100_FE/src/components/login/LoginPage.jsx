import React, { useEffect } from "react";
import { useNavigate } from "react-router";
import { useSearchParams } from "react-router-dom";

function LoginPage({ setIsLoggedIn, setUserId }) {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();

  useEffect(() => {
    // URL에서 userId를 가져옴
    const userId = searchParams.get('userId');
    
    if (userId) {
      console.log('User ID from URL:', userId);

      // userId가 URL에서 전달된 경우, 사용자 상태를 설정하고 홈으로 리디렉션
      setUserId(userId);
      setIsLoggedIn(true);
      navigate(`/${userId}`);
    } else {
      console.log('No user ID found in URL');
    }
  }, [searchParams, navigate, setIsLoggedIn, setUserId]);

  const handleLoginClick = () => {
    const clientId = import.meta.env.VITE_TEST_GOOGLE_CLIENT_ID;
    const redirectUri = import.meta.env.VITE_TEST_REDIRECT_URI;
    const googleAuthUrl = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${clientId}&redirect_uri=${redirectUri}&access_type=offline&scope=openid%20email%20profile&response_type=code`;

    // Google 로그인 페이지로 리디렉션
    window.location.href = googleAuthUrl;
  };

  return (
    <div>
      <div className="w-full min-h-[280px] flex items-center border-radius-custom bg-blue-500 bg-no-repeat p-5"></div>
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
          onClick={handleLoginClick}
        >
          <div className="w-[79px] h-[79px] bg-google-icon"></div>
          <div className="px-2 font-semibold text-base cursor-pointer">Login with Gmail</div>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;