import React from 'react';
import indexImg from "../assets/img/products-01.jpg";
import {Link} from "react-router-dom";



function Main(){
    return(
        <>
                <section className="page-section clearfix">
                    <div className="container">
                        <div className="intro">
                            <img className="intro-img img-fluid mb-3 mb-lg-0 rounded" src={indexImg} alt="..."/>
                            <div className="intro-text left-0 text-center bg-faded p-5 rounded">
                                <h2 className="section-heading mb-4">
                                    <span className="section-heading-upper">맛있어요</span>
                                    <span className="section-heading-lower">진짜 맛있어요 !</span>
                                </h2>
                                <p className="mb-3">GRIDS & CIRCLE의 모든 커피는 매장에서 직접 기른 생두를 고양이에게 먹입니다!</p>
                                <Link to="/product">
                                    <div className="intro-button mx-auto">
                                        <a className="btn btn-primary btn-lg" href="#!">
                                            판매 상품
                                        </a>
                                    </div>
                                </Link>
                            </div>
                        </div>
                    </div>
                </section>

        </>
    )
}
export default Main;