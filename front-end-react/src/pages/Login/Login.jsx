import { useForm } from 'react-hook-form';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const { register,
        handleSubmit,
        formState: { errors } } = useForm();

    const navigate = useNavigate();

    const onSubmit = async (data) => {
        console.log(data);
        try {
            const response = await axios.post("http://localhost:8080/auth/login", data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            localStorage.setItem('authToken', response.data.authToken);
            console.log('Authentication successful:', response.data);
            navigate('/')
        } catch (error) {
            console.error('Error during authentication:', error);
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-100">
            <div className="bg-white p-8 rounded-md shadow-md w-96">
                <h2 className="text-2xl font-bold mb-6">Login</h2>
                <form onSubmit={handleSubmit(onSubmit)} action="/process_login">
                    <div className="mb-4">
                        <label htmlFor="username" className="block text-sm font-medium text-gray-600">
                            Username
                        </label>
                        <input
                            type="text"
                            id="username"
                            {...register('username', {
                                required: "Username is required",
                                minLength: {
                                    value: 4,
                                    message: "Username must have at least 4 characters "
                                },
                                maxLength: {
                                    value: 100,
                                    message: "Username can't have more than 100 characters "
                                },
                                pattern: {
                                    value: /^[a-zA-Z0-9_-]+$/,
                                    message: "Username can only contain letters, numbers, underscores, and hyphens"
                                }
                            })}
                            className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                            placeholder="Enter your username"
                        />
                        {errors.username && <p className="text-red-500 text-xs italic">{errors.username.message}</p>}
                    </div>
                    <div className="mb-4">
                        <label htmlFor="password" className="block text-sm font-medium text-gray-600">
                            Password
                        </label>
                        <input
                            type="password"
                            id="password"
                            {...register('password', {
                                required: 'This field is required',
                                minLength: {
                                    value: 6,
                                    message: "Password must be at least 6 symbols"
                                }
                            })}
                            className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                            placeholder="Enter your password"
                        />
                        {errors.password && <p className="text-red-500 text-xs italic">{errors.password.message}</p>}
                    </div>
                    <div className="mb-6 flex items-center space-x-4">
                        <button
                            type="submit"
                            className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600 focus:outline-none"
                        >
                            Login
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Login;
