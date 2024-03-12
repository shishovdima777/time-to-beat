import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";


const SignUp = () => {
    const navigate = useNavigate();
    const {register,
        handleSubmit,
        watch,
        formState: {errors}} = useForm();
    // const [data, setData] = useState({
    //     email: '',
    //     username: '',
    //     password: '',
    //     confirmationPassword: ''
    // });

    // const handleChange = (e) => {
    //     setData({
    //         ...data,
    //         [e.target.name]: e.target.value
    //     });
    // };

    const onSubmit = async (data) => {
        // e.preventDefault()
        try {
            const response = await axios.post("http://localhost:8080/auth/registration", data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            localStorage.setItem("authToken", response.data.authToken);
            console.log('Registration was successful:', response.data.authToken);
            navigate('/');
        } catch (e) {
            console.log('Registration was failed ' + e);
        }
    }
    return(
        <div className="min-h-screen flex items-center justify-center bg-gray-100">
            <form onSubmit={handleSubmit(onSubmit)}>
            <div className="bg-white p-8 rounded-md shadow-md w-96">
                <h2 className="text-2xl font-bold mb-6">Signup</h2>
                <div className="mb-4">
                    <label htmlFor="email" className="block text-sm font-medium text-gray-600">
                        Email
                    </label>
                    <input
                        type="email"
                        id="email"
                        {...register('email', {
                            required: "Email is required",
                        maxLength: {
                            value: 255,
                            message: "Maximum email length is 255 characters"
                        },
                        pattern: {
                            value: /^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$/,
                            message: "Email is not valid"
                        }
                        })}
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your email"
                    />
                    {errors.email && <p className="text-red-500 text-xs italic">{errors.email.message}</p>}
                </div>
                <div className="mb-4">
                    <label htmlFor="username" className="block text-sm font-medium text-gray-600">
                        Username
                    </label>
                    <input
                        type="text"
                        id="username"
                        {...register('username', {
                            required: 'Username shouldn\'t be empty',
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
                                message: "Username can only contain latin letters, numbers, underscores, and hyphens"
                            }
                        })}
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Choose a username"
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
                <div className="mb-4 text-sm text-gray-500">
                    Password will be encrypted.
                </div>
                <div className="mb-6">
                    <label htmlFor="verifyPassword" className="block text-sm font-medium text-gray-600">
                        Verify Password
                    </label>
                    <input
                        type="password"
                        id="confirmationPassword"
                        {...register('confirmationPassword', {
                            required: 'This field is required',
                            validate: (value) => {
                                if (watch('password') !== value) {
                                    return 'Passwords do no match';
                                }
                            }

                        })}
                        className="mt-1 p-2 w-full rounded-md border border-gray-300 focus:outline-none focus:border-blue-500"
                        placeholder="Verify your password"
                    />
                    {errors.confirmationPassword && <p className="text-red-500 text-xs italic">{errors.confirmationPassword.message}</p>}
                </div>
                <div className="flex items-center space-x-4">
                    <button
                        type="submit"
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
            </form>
        </div>
    );
}

export default SignUp;