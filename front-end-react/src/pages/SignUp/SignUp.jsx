const SignUp = () => {
    return(
        <div className="min-h-screen flex items-center justify-center bg-gray-100">
            <div className="bg-white p-8 rounded-md shadow-md w-96">
                <h2 className="text-2xl font-bold mb-6">Signup</h2>
                <div className="mb-4">
                    <label htmlFor="email" className="block text-sm font-medium text-gray-600">
                        Email
                    </label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your email"
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="username" className="block text-sm font-medium text-gray-600">
                        Username
                    </label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Choose a username"
                    />
                </div>
                <div className="mb-4">
                    <label htmlFor="password" className="block text-sm font-medium text-gray-600">
                        Password
                    </label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your password"
                    />
                </div>
                <div className="mb-4 text-sm text-gray-500">
                    Password will be encrypted.
                </div>
                <div className="mb-6">
                    <label htmlFor="verifyPassword" className="block text-sm font-medium text-gray-600">
                        Verify Password
                    </label>
                    <input
                        type="password"
                        id="verifyPassword"
                        name="verifyPassword"
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Verify your password"
                    />
                </div>
                <div className="flex items-center space-x-4">
                    <button
                        type="button"
                        className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600 focus:outline-none"
                    >
                        Create
                    </button>
                    <button
                        type="button"
                        className="text-gray-500 px-4 py-2 rounded-md hover:text-gray-700 focus:outline-none"
                    >
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    );
}

export default SignUp;