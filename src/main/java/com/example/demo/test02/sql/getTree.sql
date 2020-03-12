--创建一个函数用于查询树型子目录
DELIMITER $$
DROP FUNCTION IF EXISTS `getChild`$$
CREATE FUNCTION getChild(parentId VARCHAR(16000))
RETURNS VARCHAR(16000)
BEGIN
    DECLARE oTemp VARCHAR(16000);
    DECLARE oTempChild VARCHAR(16000);
    SET oTemp = '';
    SET oTempChild = parentId;
    WHILE oTempChild is not null DO
        IF oTemp != '' THEN
            SET oTemp = concat(oTemp,',',oTempChild);
        ELSE
            SET oTemp = oTempChild;
        END IF;
        SELECT group_concat(pool_code) INTO oTempChild FROM hrm_person_pool where deleted !=1 and parentId != pool_code and FIND_IN_SET(parent_pool_code, oTempChild)>0;
    END WHILE;
RETURN oTemp;
END $$
DELIMITER ;
--创建一个函数用于查询树型父目录
DELIMITER $$
DROP FUNCTION IF EXISTS `getParent`$$
CREATE FUNCTION `getParent`(childrenId  VARCHAR(16000))
RETURNS varchar(16000)
BEGIN
  DECLARE sParentList varchar(16000);
  DECLARE sParentTemp varchar(16000);
  SET sParentList = '';
  SET sParentTemp = childrenId;
    WHILE sParentTemp is not null DO
      IF sParentList != '' THEN
        SET sParentList = concat(sParentTemp,',',sParentList);
      ELSE
        SET sParentList = concat(sParentTemp);
      END IF;
      SELECT group_concat(parent_pool_code) INTO sParentTemp FROM hrm_person_pool where deleted !=1 and FIND_IN_SET(pool_code,sParentTemp)>0;
    END WHILE;
  RETURN sParentList;
END $$
DELIMITER ;

--设置自动更新时间
ALTER TABLE `table_name` MODIFY COLUMN  `CreateTime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ;

--设置更新时间自动更新
ALTER TABLE hrm_apply MODIFY COLUMN updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
ALTER TABLE hrm_dict MODIFY COLUMN updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
ALTER TABLE hrm_employee MODIFY COLUMN updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
ALTER TABLE hrm_interview MODIFY COLUMN updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
ALTER TABLE hrm_person_pool MODIFY COLUMN updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

