import React, { useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router';
import axios from 'axios';

function LoginCallback({ setIsLoggedIn, setUserId }) {
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    const fetchUserData = async (code) => {
      try {
        const response = await axios.post(`${import.meta.env.VITE_BACKEND_ENDPOINT}/auth/google`, {
          code,
          redirectUri: import.meta.env.VITE_TEST_REDIRECT_URI,
          clientId: import.meta.env.VITE_TEST_GOOGLE_CLIENT_ID,
        });

        console.log('User data fetched:', response.data);
        const { userId } = response.data;
        setUserId(userId);
        setIsLoggedIn(true);

        console.log('Navigating to home page...');
        navigate(-1);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    const urlParams = new URLSearchParams(location.search);
    const code = urlParams.get('code');

    if (code) {
      fetchUserData(code);
    }
  }, [navigate, setIsLoggedIn, setUserId, location.search]);

  return <div>Loading...</div>;
}

export default LoginCallback;