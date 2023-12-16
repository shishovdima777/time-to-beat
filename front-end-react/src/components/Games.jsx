const Games = ({games}) => {

    return(
        <>
            <ul className="flex flex-wrap gap-0 justify-center">
                {games.map((game) => (
                    <li key={game.gameName} className="bg-white p-8 rounded-md shadow-md w-150 min-w-[450px] max-w-[450px] mx-auto mb-8">
                        <div className="flex">
                            {/* Game Image on the left */}
                            <img className="rounded-md mr-6" src={game.url.replace(`thumb`, `logo_med`)}/>
                            <div>
                                <h3 className="text-2xl font-semibold mb-4">{game.gameName}</h3>
                                <div className="text-gray-700">
                                    <div className="mb-2">
                                        <span className="font-bold">Main Story:</span> {game.avgMainStoryHours} hours
                                    </div>
                                    <div className="mb-2">
                                        <span className="font-bold">Main Story + Extra:</span> {game.avgMainPlusDlcHours} hours
                                    </div>
                                    <div className="mb-2">
                                        <span className="font-bold">Completionist:</span> {game.avgCompletionistHours} hours
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                ))}
            </ul>
        </>
    );
}

export default Games;