package com.ecommerce.service.InventoryServiceImpl;

import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStrock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
