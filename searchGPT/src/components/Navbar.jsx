import React from 'react'

function Navbar() {
  return (
    <>
      <nav class="h-96 bg-gradient-to-t from-gray-200 to-gray-100 rounded-br-[96px]" >
        <div class="flex flex-wrap justify-between items-center mx-auto max-w-screen-xl p-4">
            <a href="" class="flex items-center space-x-3 rtl:space-x-reverse">
                <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Logo Gelecek</span>
            </a>
        </div>
      </nav>
    </>
  )
}

export default Navbar