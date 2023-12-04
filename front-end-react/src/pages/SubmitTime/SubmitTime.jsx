const SubmitTime = () => {
    const gameData = {
        gameName: 'Alan Wake 2',
        imageUrl: 'https://howlongtobeat.com/games/101237_Alan_Wake_2.jpg?width=250',
    };
    return(
        <div className="container mx-auto mt-8 p-8 bg-white rounded-md shadow-md flex">
            {/* 1st part - Community Stats */}
            <div className="pr-8">
                <h2 className="text-2xl font-bold mb-4">Community Stats</h2>

                {/* Image of the Game */}
                <img
                    src={gameData.imageUrl}
                    alt={gameData.gameName}
                    className="w-full h-auto max-w-[250px] max-h-[333px] rounded-md mb-4"
                />

                {/* Actual Stats */}
                <div className="bg-gray-200 p-4 rounded-md mb-4 max-w-[250px]">
                    <p className="text-gray-700">Average Main Story Time: 12 hours 30 minutes</p>
                    <p className="text-gray-700">Average Main Story + Extra Time: 18 hours 45 minutes</p>
                    <p className="text-gray-700">Average Completionist Time: 24 hours 15 minutes</p>
                </div>
            </div>

            {/* 2nd part - Form */}
            <div className="flex-1">
                {/* Form */}
                <form className="bg-gray-200 p-8 rounded-md">
                    <h2 className="text-2xl font-bold mb-6">Submit Your Time</h2>

                    {/* Main Story Input */}
                    <div className="flex mb-4">
                        <div className="w-1/2 pr-4">
                            <label htmlFor="mainStoryHours" className="block text-gray-700 font-bold mb-2">
                                Main Story Time (hours)
                            </label>
                            <input
                                type="number"
                                id="mainStoryHours"
                                name="mainStoryHours"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                        <div className="w-1/2 pl-4">
                            <label htmlFor="mainStoryMinutes" className="block text-gray-700 font-bold mb-2">
                                Minutes
                            </label>
                            <input
                                type="number"
                                id="mainStoryMinutes"
                                name="mainStoryMinutes"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                    </div>

                    {/* Main Story + Extra Input */}
                    <div className="flex mb-4">
                        <div className="w-1/2 pr-4">
                            <label htmlFor="mainPlusExtraHours" className="block text-gray-700 font-bold mb-2">
                                Main Story + Extra Time (hours)
                            </label>
                            <input
                                type="number"
                                id="mainPlusExtraHours"
                                name="mainPlusExtraHours"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                        <div className="w-1/2 pl-4">
                            <label htmlFor="mainPlusExtraMinutes" className="block text-gray-700 font-bold mb-2">
                                Minutes
                            </label>
                            <input
                                type="number"
                                id="mainPlusExtraMinutes"
                                name="mainPlusExtraMinutes"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                    </div>

                    {/* Completionist Input */}
                    <div className="flex mb-6">
                        <div className="w-1/2 pr-4">
                            <label htmlFor="completionistHours" className="block text-gray-700 font-bold mb-2">
                                Completionist Time (hours)
                            </label>
                            <input
                                type="number"
                                id="completionistHours"
                                name="completionistHours"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                        <div className="w-1/2 pl-4">
                            <label htmlFor="completionistMinutes" className="block text-gray-700 font-bold mb-2">
                                Minutes
                            </label>
                            <input
                                type="number"
                                id="completionistMinutes"
                                name="completionistMinutes"
                                className="w-full px-3 py-2 border rounded-md"
                            />
                        </div>
                    </div>

                    {/* Submit Button */}
                    <button
                        type="submit"
                        className="bg-blue-500 text-white px-6 py-3 rounded-md hover:bg-blue-600 transition duration-300"
                    >
                        Submit
                    </button>
                </form>
            </div>
        </div>
    );
}
export default SubmitTime;