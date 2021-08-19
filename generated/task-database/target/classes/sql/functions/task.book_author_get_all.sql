DROP FUNCTION IF EXISTS task.book_author_get_all;
CREATE FUNCTION task.book_author_get_all(
  in_login_id BIGINT
)
RETURNS TABLE (
  book_author_id BIGINT,
  author_id BIGINT,
  book_id BIGINT)
AS $$
/******************************************************************************
**		File: task.book_author_get_all.sql
**		Name: task.book_author_get_all
**		Desc: Get book_authors data
*******************************************************************************
**		Auth: laziz
**		Date: 2021-08-19
*******************************************************************************
**		Change History
**		Date: 			Author:				Description:
*******************************************************************************
**		2021-08-19		laziz     	Created
**
*******************************************************************************
**		Return values: book_author infor.
*******************************************************************************
**/

DECLARE
  FN_NAME CONSTANT TEXT := 'task.book_author_get_all';
  STEP_INDEX INTEGER;
  STEP_DESC VARCHAR(500);
BEGIN

---------------------------------------------------------------------------------------------------------------------------------------------------
  STEP_INDEX := 0;
  STEP_DESC := FN_NAME || ': Initialized ...';
  RAISE NOTICE '%', STEP_DESC;
----------------------------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------------------------------------------------------------------------------------------------------------
  STEP_INDEX := 10;
  STEP_DESC := FN_NAME || ': Validation check permission';
  RAISE NOTICE '%', STEP_DESC;
----------------------------------------------------------------------------------------------------------------------------------------------------
-- to do need to complete this step

  IF in_login_id IS NULL OR in_login_id < 0 THEN
      RAISE EXCEPTION 'Nonexistent ID --> % step % %', in_login_id, STEP_INDEX, STEP_DESC
      USING HINT = 'Please check your login';
  END IF;

---------------------------------------------------------------------------------------------------------------------------------------------------
  STEP_INDEX := 20;
  RAISE NOTICE '%', FN_NAME || ': Select Data';
----------------------------------------------------------------------------------------------------------------------------------------------------
  RETURN QUERY
    SELECT
        book_author.book_author_id,
        book_author.author_id,
        book_author.book_id    FROM task.book_author
    WHERE
        NOT book_author.deleted;
END;
$$ LANGUAGE plpgsql;