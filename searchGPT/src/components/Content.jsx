import React from 'react'

function Content() {
  return (
    <>
        <div class="flex flex-row justify-normal items-start h-full mx-auto max-w-screen-xl p-4 ">
            <div className='flex flex-col w-96 bg-violet-50 p-6'>
                <p className='font-semibold text-xl pb-6 '>en çok sorulanlar</p>
                <ul className='pb-3'>
                    <li><a href="">Lorem ipsum dolor sit amet consectetur adipi sicing elit.</a></li>
                </ul>
                <ul className='pb-3'>
                    <li><a href="">Lorem ipsum dolor sit amet consectetur adipis icing elit.</a></li>
                </ul>
                <ul className='pb-3'>
                    <li><a href="">Lorem ipsum dolor sit amet consectetur adipi sicing elit.</a></li>
                </ul>
                <ul className='pb-3'>
                    <li><a href="">Lorem ipsum dolor sit amet consectetur adipi sicing elit.</a></li>
                </ul>
                
            </div>

            <div class="flex-grow">
                Flex item 2
            </div>
        </div>
        <div class=" flex ">
            
        </div>
    </>
  )
}

export default Content