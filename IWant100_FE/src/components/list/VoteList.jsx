import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function getRandomColor() {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function VoteList({ searchTerm }) {
  const HOST = import.meta.env.VITE_TEST_HOST;

  const navigate = useNavigate();
  const [votes, setVotes] = useState([]);
  const [userId, setUserId] = useState('b635ee82-a8ea-4854-9e3d-a218532d1d0a');

  useEffect(() => {
    const fetchVotes = async () => {
      try {
        const response = await fetch(`${HOST}/vote/all`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          },
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        if (result.success) {
          setVotes(result.voteList || []);
        } else {
          console.error(result.message);
        }
      } catch (error) {
        console.error('Error fetching votes:', error);
      }
    };

    fetchVotes();
  }, [HOST]);

  const handleBoxClick = async (voteId, endAt) => {
    if (!userId) {
      console.error('User ID is not defined');
      return;
    }
    
    const currentDate = new Date();
    const endDate = new Date(endAt);

    const currentDateNoTime = new Date(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate()).getTime();
    const endDateNoTime = new Date(endDate.getFullYear(), endDate.getMonth(), endDate.getDate()).getTime();

    if (currentDateNoTime > endDateNoTime) {
      console.log('Navigating to result page due to date condition');
      navigate(`/result/${voteId}`);
      return;
    }

    try {
      const response = await fetch(`${HOST}/vote-content/vote/${voteId}/user/${userId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const result = await response.json();
      
      if (result.success && result.voteInfo) {
        navigate(`/vote/${voteId}`);
      } else {
        navigate(`/result/${voteId}`);
      }
    } catch (error) {
      console.error('Error checking vote details:', error);
    }
  };

  const filteredVotes = votes.filter((vote) =>
    vote.voteIntro.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="px-8 text-left" style={{ height: '65vh', overflow: 'hidden' }}>
      <div className="overflow-y-auto" style={{ height: '100%' }}>
        {filteredVotes.map((vote) => (
          <div 
            key={vote.voteId}
            className="bg-white p-4 rounded-lg shadow-md mb-8 cursor-pointer" 
            onClick={() => handleBoxClick(vote.voteId, vote.endAt)}
          >
            <div className="flex justify-between items-center mb-2">
              <p className="font-bold ml-1 mb-4 font-esamanru">{vote.voteIntro}</p>
              <p className="text-red-500 font-bold text-xs mr-1 mb-4">
                D-{Math.ceil((new Date(vote.endAt) - new Date()) / (1000 * 60 * 60 * 24)) === 0 ? 'day' : Math.ceil((new Date(vote.endAt) - new Date()) / (1000 * 60 * 60 * 24)) < 0 ? 'end' : Math.abs(Math.ceil((new Date(vote.endAt) - new Date()) / (1000 * 60 * 60 * 24)))}
              </p>
            </div>
            <div className="flex justify-between items-center mb-2">
              <p className="text-xs ml-1 font-semibold">{`${vote.voteCount || 0}명 참여`}</p>
              <p className="text-xs mr-1 font-semibold">{vote.voteItemContent}</p>
            </div>
            <div className="flex items-center justify-between">
              <div className="w-full bg-gray-200 rounded h-2.5">
                <div className="h-2.5 rounded" style={{ width: `${(vote.voteItemCount / (vote.voteCount || 1)) * 100}%`, backgroundColor: getRandomColor() }}></div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default VoteList;
