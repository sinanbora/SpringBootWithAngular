import React from 'react'

function Searchbar() {
  return (
    <>
        <form className='-mt-12 items-center mx-auto max-w-screen-xl p-4'>   
            <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only">Search</label>
            <div class="relative mx-auto">
                <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                    <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
                    </svg>
                </div>
                <input type="search" id="default-search" class="block w-full h-16 p-4 ps-10 text-lg text-gray-900 border border-gray-200 bg-gray-50 focus:outline-none" placeholder="Lütfen sorunuzu yazınız..." required>
                </input>
                <button type="submit" class="text-white absolute end-2.5 bottom-2 h-12 w-24 bg-violet-600 hover:bg-violet-800 focus:outline-none font-medium text-sm px-2 py-2">Ara</button>
            </div>
        </form>
    </>
  )
}

export default Searchbar