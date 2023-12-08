import React, { useState } from 'react';
const User = () => {
    const userData = {
        avatarUrl: 'https://howlongtobeat.com/games/101237_Alan_Wake_2.jpg?width=250',
        username: 'Alan Wake',
    };

    const [activeSection, setActiveSection] = useState('Profile');

    return  (
        <div className="container mx-auto mt-8 p-8 bg-white rounded-md shadow-md flex flex-wrap">
            {/* Left side with Avatar and Username */}
            <div className="pr-8">
                {/* User Avatar */}
                <img
                    src={userData.avatarUrl}
                    alt={`${userData.username}'s avatar`}
                    className="w-full h-auto max-w-[250px] rounded-md mb-4 shadow-md"
                />

                {/* Username */}
                <h2 className="text-2xl font-bold text-gray-800">{userData.username}</h2>
            </div>

            {/* Right side with Header, Navigation Bar, Time Display Bar, and Game Description */}
            <div className="flex-1">
                {/* Header */}
                <h2 className="text-2xl font-bold mb-4">Profile Information</h2>

                {/* Navigation Bar */}
                <div className="bg-gray-200 p-4 rounded-md mb-4">
                    <nav className="flex space-x-4">
                        <button
                            onClick={() => setActiveSection('Profile')}
                            className={`text-blue-500 hover:underline hover:text-blue-700`}
                        >
                            Profile
                        </button>
                        <button
                            onClick={() => setActiveSection('Games')}
                            className={`text-blue-500 hover:underline hover:text-blue-700`}
                        >
                            Games
                        </button>
                        <button
                            onClick={() => setActiveSection('Reviews')}
                            className={`text-blue-500 hover:underline hover:text-blue-700`}
                        >
                            Reviews
                        </button>
                    </nav>
                </div>

                {/* Game Description Container */}
                <div className="bg-gray-200 p-6 rounded-md">
                    {activeSection === 'Profile' && (
                        <div>
                            {/* Add user profile information here */}
                            <p className="text-gray-800 mb-2">About me: </p>
                            {/* Add more information as needed */}
                        </div>
                    )}

                    {/* Add sections for Games and Reviews if needed */}
                    {/* {activeSection === 'Games' && (
            // Content for Games section
          )}

          {activeSection === 'Reviews' && (
            // Content for Reviews section
          )} */}
                </div>
            </div>
        </div>
    );
}

export default User;