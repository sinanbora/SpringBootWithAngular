import React from 'react'
import logo from "../assets/logo.png"

function Navbar() {
  return (
    <>
      <nav class="h-96 bg-gradient-to-t from-gray-100 to-gray-50 rounded-br-[96px]" >
        <div class="flex flex-wrap justify-between items-center mx-auto max-w-screen-xl p-4">
            <a href="" class="flex items-center space-x-3 ">
                <img src={logo} class="h-12" alt="Flowbite Logo" />
                <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">ANKARA ÜNİVERSİTESİ SOSYAL HİZMETLER</span>
            </a>
        </div>
        <div class="flex justify-between items-center mx-auto max-w-screen-xl p-4 pt-24">
            <a href="" class="flex items-center space-x-3 ">
                <span class="self-center text-6xl whitespace-nowrap text-gray-600">102 remote <span className='text-violet-600 font-semibold'>design</span> jobs </span>
            </a>
        </div>
        <div class="flex justify-between items-center mx-auto max-w-screen-xl p-4">
            <a href="" class="flex items-center space-x-3 ">
                <span class="self-center text-xl whitespace-nowrap text-gray-500">102 remote design jobs available at companies like <span className='text-violet-600 font-semibold'>Intercom, Spotify</span> and <span className='text-violet-600 font-semibold'>Twitter</span></span>
            </a>
        </div>
      </nav>
    </>
  )
}

export default Navbar