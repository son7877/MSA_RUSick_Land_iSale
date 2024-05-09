package com.example.iSale;

import com.example.iSale.domain.entity.ISaleEnroll;
import com.example.iSale.domain.repository.ISaleEnrollRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class iSaleEnrollScheduled {

    private final ISaleEnrollRepository iSaleEnrollRepository;

    @Scheduled(cron = "0 */5 * * * *")
    public void iSaleEnrollQualification() {
        List<ISaleEnroll> byQualTfIsNull = iSaleEnrollRepository.findByQualTFIsNull();

        for(ISaleEnroll iSaleEnroll : byQualTfIsNull) {
            int score = 25;

            // 나이에 따른 자격 점수 부여
            if(iSaleEnroll.getAge() < 19){
                score += 0;
            } else if(iSaleEnroll.getAge() < 20){
                score += 15;
            } else if (iSaleEnroll.getAge() < 30){
                score += 20;
            } else {
                score += 25;
            }

            // 수입에 따른 자격 점수 부여
            if(iSaleEnroll.getIncome() > 60000000) {
                score += 10;
            } else if(iSaleEnroll.getIncome() > 50000000){
                score += 15;
            } else if (iSaleEnroll.getIncome() > 40000000){
                score += 20;
            } else {
                score += 25;
            }

            // 자녀 수에 따른 자격 점수 부여
            if (iSaleEnroll.getChild() < 1){
                score += 10;
            } else if(iSaleEnroll.getChild() < 2){
                score += 15;
            } else if (iSaleEnroll.getChild() < 3){
                score += 20;
            } else {
                score += 25;
            }

            // 매물 여부에 따른 자격 점수 부여
            // todo 코드 작성

            // score 점수 75점 초과일 경우 true 부여
            iSaleEnroll.setQualTF(score > 75);
        }

    }
}
