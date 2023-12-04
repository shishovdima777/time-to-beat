const Game = () => {

    const gameData = {
        gameName: 'Alan Wake 2',
        imageUrl: 'https://howlongtobeat.com/games/101237_Alan_Wake_2.jpg?width=250',
        submitTimeLink: '/game/submit-time',
        overviewLink: '/overview',
        reviewsLink: '/reviews',
        mainStoryHours: '10',
        mainPlusExtraHours: '15',
        completionistHours: '20',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ...',
    };

    return (
        <div className="container mx-auto mt-8 p-8 bg-white rounded-md shadow-md flex flex-wrap">
            {/* Left side with Image and Submit Your Time */}
            <div className="w-auto pr-8 rounded-md">
                {/* Game Image */}
                <img
                    src={gameData.imageUrl}
                    alt={gameData.gameName}
                    className="w-full h-auto max-w-[250px] max-h-[333px] rounded-md mb-4"
                />

                {/* Submit Your Time Button */}
                <a
                    href={gameData.submitTimeLink}
                    className="text-blue-500 hover:underline hover:text-blue-700 block"
                >
                    Submit Your Time
                </a>
            </div>

            {/* Right side with Header, Navigation Bar, Time Display Bar, and Game Description */}
            <div className="flex-1">
                {/* Header and Navigation Bar */}
                <h2 className="text-2xl font-bold mb-4">{gameData.gameName}</h2>
                <div className="bg-gray-200 p-4 rounded-md mb-4">


                    {/* Navigation Bar */}
                    <nav className="flex space-x-4">
                        <a href={gameData.overviewLink} className="text-blue-500 hover:underline hover:text-blue-700">Overview</a>
                        <a href={gameData.reviewsLink} className="text-blue-500 hover:underline hover:text-blue-700">Reviews</a>
                        {/* Add more links as needed */}
                    </nav>
                </div>

                {/* Time Display Bar */}
                <div className="bg-gray-200 p-4 rounded-md mb-4">
                    <p className="text-gray-700">Main Story: {gameData.mainStoryHours} hours</p>
                    <p className="text-gray-700">Main Story + Extra: {gameData.mainPlusExtraHours} hours</p>
                    <p className="text-gray-700">Completionist: {gameData.completionistHours} hours</p>
                </div>

                {/* Game Description Container */}
                <div className="bg-gray-200 p-6 rounded-md">
                    <p className="text-gray-800">{gameData.description}</p>
                </div>
            </div>
        </div>
    );
}

export default Game;