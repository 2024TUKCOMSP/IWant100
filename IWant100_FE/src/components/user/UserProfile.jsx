import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router";

function UserProfile() {
  const HOST = import.meta.env.VITE_TEST_HOST;
  
  const [userInfo, setUserInfo] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { userId } = useParams();

  useEffect(() => {
    const fetchUserInfo = async () => {
      try {
        const response = await axios.get(`${HOST}/user/${userId}`, {
          headers: {
            'Content-Type': 'application/json',
          },
        });
        console.log('API response:', response);
        if (response.data.success) {
          setUserInfo(response.data.userInfo);
        } else {
          setError(response.data.message);
        }
      } catch (err) {
        console.error('API call error:', err);
        setError("사용자 정보를 가져오는 데 실패했습니다.");
      } finally {
        setLoading(false);
      }
    };

    fetchUserInfo();
  }, [userId]); // Adding userId as a dependency to useEffect to refetch if userId changes

  if (loading) return <div>로딩 중...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div className="rounded-[30px] bg-[#E8ECFA] flex flex-col box-sizing-border mt-10">
      <div className="shadow-[0px_4px_4px_0px_rgba(0,0,0,0.25)] rounded-[10px] bg-[#D4E1FA] relative m-[0_0_28px_5px] flex flex-row justify-between p-[11px_15px_17px_12px] w-[calc(100%_-_5px)] box-sizing-border">
        <div className="rounded-full m-[0_11px_0_0] flex h-[100px] grow basis-[100px] box-sizing-border">
          <div
            className="shadow-[0px_4px_4px_0px_rgba(0,0,0,0.25)] rounded-full border border-black bg-cover bg-center"
            style={{ backgroundImage: `url(${userInfo?.userImage})`, width: '100px', height: '100px' }}
          ></div>
        </div>
        <div className="rounded-[16px] bg-white relative m-[11px_0_4.7px_0] p-[11px_11.3px_0_11.3px] grow basis-[237px] box-sizing-border">
          <div className="bg-white relative box-sizing-border">
            <div className="flex flex-col box-sizing-border">
              <div className="flex flex-row items-center mb-2">
                <div className="rounded-full bg-[#CCEAFF] flex items-center p-[6px_15.6px] mr-4 box-sizing-border">
                  <span className="break-words font-['Poppins'] font-semibold text-[10px] text-[#444444]">이름</span>
                </div>
                <div className="inline-block break-words font-['Poppins'] font-normal text-[10px] leading-[1.6] text-[#444444]">
                  {userInfo?.nickName}
                </div>
              </div>
              <div className="flex flex-row items-center">
                <div className="rounded-full bg-[#CCEAFF] flex items-center p-[6px_15.4px] mr-4 box-sizing-border">
                  <span className="break-words font-['Poppins'] font-semibold text-[10px] text-[#444444]">이메일</span>
                </div>
                <div className="inline-block break-words font-['Poppins'] font-normal text-[10px] leading-[1.6] text-[#444444]">
                  {userInfo?.email}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserProfile;
